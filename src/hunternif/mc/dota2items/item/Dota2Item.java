package hunternif.mc.dota2items.item;

import hunternif.mc.dota2items.ClientProxy;
import hunternif.mc.dota2items.Dota2Items;
import hunternif.mc.dota2items.Sound;
import hunternif.mc.dota2items.client.gui.ColorHelper;
import hunternif.mc.dota2items.config.Config;
import hunternif.mc.dota2items.core.EntityStats;
import hunternif.mc.dota2items.core.buff.Buff;
import hunternif.mc.dota2items.inventory.Column;
import hunternif.mc.dota2items.inventory.InventoryShop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Dota2Item extends Item {
	private boolean dropsOnDeath = false;
	private Buff passiveBuff;
	private Column shopColumn;
	private int defaultQuantity = 1;
	private float weaponDamage = 0;
	/** Used by upgraded versions of upgradable items to point to the original item. */
	private Dota2Item baseShopItem;
	
	public static int maxTooltipWidth = 128;
	private List<String> descriptionLines;
	
	/** If this item has a recipe, this "price" represents the price of the recipe. */
	private int price;
	private Set<Dota2Item> usedInRecipes = new HashSet<Dota2Item>();
	private List<Dota2Item> recipe;
	
	public Dota2Item(int id) {
		super(id);
		setCreativeTab(Dota2Items.dota2CreativeTab);
		setMaxStackSize(1);
	}
	
	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		if (weaponDamage > 0) {
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
		}
		return multimap;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(Dota2Items.ID + ":" + getUnlocalizedName().substring("item.".length()));
	}
	
	public Dota2Item setWeaponDamage(float damage) {
		this.weaponDamage = damage;
		return this;
	}
	public float getWeaponDamage() {
		return this.weaponDamage;
	}
	
	public Dota2Item setDefaultQuantity(int value) {
		this.defaultQuantity = value;
		return this;
	}
	public int getDefaultQuantity() {
		return this.defaultQuantity;
	}
	
	public Dota2Item setDropsOnDeath(boolean value) {
		this.dropsOnDeath = value;
		return this;
	}
	public boolean getDropsOnDeath() {
		return this.dropsOnDeath;
	}
	
	public Dota2Item setShopColumn(Column column) {
		this.shopColumn = column;
		return this;
	}
	public Column getShopColumn() {
		return this.shopColumn;
	}
	
	public Dota2Item setPassiveBuff(Buff buff) {
		this.passiveBuff = buff;
		return this;
	}
	public Buff getPassiveBuff() {
		return this.passiveBuff;
	}
	
	public Dota2Item setBaseShopItem(Dota2Item item) {
		this.baseShopItem = item;
		return this;
	}
	public Dota2Item getBaseShopItem() {
		return this.baseShopItem;
	}
	
	public Dota2Item setDescriptionLines(List<String> lines) {
		this.descriptionLines = lines;
		return this;
	}
	
	public static void playDenyGeneralSound(EntityPlayer player) {
		if (player.worldObj.isRemote) {
			Minecraft.getMinecraft().sndManager.playSoundFX(Sound.DENY_GENERAL.getName(), 1.0F, 1.0F);
		}
	}
	
	public Dota2Item setPrice(int price) {
		this.price = price;
		return this;
	}
	public Dota2Item setRecipePrice(int price) {
		setPrice(price);
		return this;
	}
	public Dota2Item setRecipe(List<Dota2Item> list) {
		this.recipe = list;
		for (Dota2Item item : list) {
			item.usedInRecipes.add(this);
		}
		return this;
	}
	public Dota2Item setRecipe(List<Dota2Item> list, int priceOfRecipe) {
		setRecipe(list);
		setRecipePrice(priceOfRecipe);
		return this;
	}
	public boolean hasRecipe() {
		return recipe != null && !recipe.isEmpty();
	}
	public boolean isRecipeItemRequired() {
		return hasRecipe() && price > 0;
	}
	public List<Dota2Item> getRecipe() {
		return recipe;
	}
	public Set<Dota2Item> getUsedInRecipes() {
		return usedInRecipes;
	}
	public int getRecipePrice() {
		return price;
	}
	public int getTotalPrice() {
		int totalPrice = getRecipePrice();
		if (hasRecipe()) {
			for (Dota2Item dota2Item : recipe) {
				totalPrice += dota2Item.getTotalPrice();
			}
		}
		return totalPrice;
	}
	public int getSellPrice() {
		return getTotalPrice()/2;
	}
	
	@Override
	public String getItemDisplayName(ItemStack stack) {
		return ColorHelper.prefixForColumn(shopColumn) + super.getItemDisplayName(stack);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean showAdvanced) {
		boolean isRecipe = stack.itemID == Config.recipe.getID();
		int itemPrice = isRecipe ? this.getRecipePrice() : this.getTotalPrice();
		list.add(ClientProxy.ICON_GOLD.key + EnumChatFormatting.GOLD + itemPrice*stack.stackSize);
		
		if (descriptionLines != null) {
			list.addAll(descriptionLines);
		}
		
		if (this instanceof ActiveItem) {
			float cooldown = ((ActiveItem)this).getCooldown();
			String cooldownStr;
			if (cooldown != MathHelper.floor_float(cooldown)) {
				cooldownStr = String.format("%.1f", cooldown);
			} else {
				cooldownStr = String.format("%.0f", cooldown);
			}
			if (((ActiveItem)this).getManaCost() > 0) {
				cooldownStr += "     " + ClientProxy.ICON_MANACOST.key + EnumChatFormatting.GRAY + ((ActiveItem)this).getManaCost();
			}
			list.add(ClientProxy.ICON_COOLDOWN.key + EnumChatFormatting.GRAY + cooldownStr);
		}
		// If the item is displayed in shop
		if (isSampleItemStack(stack)) {
			if (Dota2Items.stats.getOrCreateEntityStats(player).getGold() < itemPrice*stack.stackSize) {
				list.add(EnumChatFormatting.DARK_RED + "Not enough gold");
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public FontRenderer getFontRenderer(ItemStack stack) {
		return ClientProxy.fontRWithIcons;
	}
	
	public static boolean isSampleItemStack(ItemStack itemStack) {
		NBTTagCompound tag = itemStack.getTagCompound();
		return tag != null && tag.getBoolean(InventoryShop.TAG_IS_SAMPLE);
	}
	
	public static boolean canBuy(ItemStack itemStack, EntityPlayer player) {
		int curPrice = 0;
		if (itemStack.getItem() instanceof Dota2Item) {
			curPrice = ((Dota2Item)itemStack.getItem()).getTotalPrice() * itemStack.stackSize;
		} else if (itemStack.getItem() instanceof ItemRecipe) {
			curPrice = ItemRecipe.getPrice(itemStack);
		}
		EntityStats stats = Dota2Items.stats.getOrCreateEntityStats(player);
		return stats.getGold() >= curPrice;
	}
	public static boolean hasRecipe(ItemStack itemStack) {
		return itemStack.getItem() instanceof Dota2Item &&
				((Dota2Item)itemStack.getItem()).hasRecipe();
	}
	public static boolean isUsedInRecipe(ItemStack itemStack) {
		return itemStack.getItem() instanceof Dota2Item &&
				!((Dota2Item)itemStack.getItem()).usedInRecipes.isEmpty();
	}
	
	public static int getPrice(ItemStack itemStack) {
		if (itemStack == null) {
			return 0;
		}
		if (itemStack.getItem() instanceof Dota2Item) {
			Dota2Item item = (Dota2Item) itemStack.getItem(); 
			return item.getTotalPrice() * itemStack.stackSize;
		} else if (itemStack.getItem() instanceof ItemRecipe) {
			return ItemRecipe.getPrice(itemStack) * itemStack.stackSize;
		} else {
			return 0;
		}
	}
	public static int getSellPrice(ItemStack itemStack) {
		return getPrice(itemStack)/2;
	}
}
