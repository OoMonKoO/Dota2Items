package hunternif.mc.dota2items.config;

import hunternif.mc.dota2items.block.BlockCycloneContainer;
import hunternif.mc.dota2items.core.buff.Buff;
import hunternif.mc.dota2items.inventory.Column;
import hunternif.mc.dota2items.item.BlinkDagger;
import hunternif.mc.dota2items.item.Dota2Item;
import hunternif.mc.dota2items.item.Dota2Logo;
import hunternif.mc.dota2items.item.EulsScepter;
import hunternif.mc.dota2items.item.GoldCoin;
import hunternif.mc.dota2items.item.ItemRecipe;
import hunternif.mc.dota2items.item.QuellingBlade;
import hunternif.mc.dota2items.item.Tango;

public class Config {
	// Special items
		public static CfgInfo<Dota2Logo> dota2Logo = new CfgInfo<Dota2Logo>(27000, "Dota 2 Logo");
		public static CfgInfo<GoldCoin> goldCoin = new CfgInfo<GoldCoin>(27007, "Gold Coin");
		public static CfgInfo<ItemRecipe> recipe = new CfgInfo<ItemRecipe>(27011, "Recipe");
		
		// Items column: Secret Shop ==================================================================
//		orbOfVenom
		public static CfgInfo<Dota2Item> ringOfHealth = new CfgInfo<Dota2Item>(27039, "Ring of Health")
				.setPrice(875).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Ring of Health").setHealthRegen(5));
		public static CfgInfo<Dota2Item> voidStone = new CfgInfo<Dota2Item>(27008, "Void Stone")
				.setPrice(875).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Void Stone").setManaRegenPercent(100));
		public static CfgInfo<Dota2Item> hyperstone = new CfgInfo<Dota2Item>(27040, "Hyperstone")
				.setPrice(2100).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Hyperstone").setAttackSpeed(55));
		public static CfgInfo<Dota2Item> demonEdge = new CfgInfo<Dota2Item>(27041, "Demon Edge")
				.setPrice(2400).setColumn(Column.SECRET_SHOP)
				.setWeaponDamage(7).setPassiveBuff(new Buff("Demon Edge").setDamage(46));
		public static CfgInfo<Dota2Item> sacredRelic = new CfgInfo<Dota2Item>(27042, "Sacred Relic")
				.setPrice(3800).setColumn(Column.SECRET_SHOP)
				.setWeaponDamage(7).setPassiveBuff(new Buff("Sacred Relic").setDamage(60));
		public static CfgInfo<Dota2Item> reaver = new CfgInfo<Dota2Item>(27043, "Reaver")
				.setPrice(3200).setColumn(Column.SECRET_SHOP)
				.setWeaponDamage(7).setPassiveBuff(new Buff("Reaver").setStrength(25));
		public static CfgInfo<Dota2Item> eaglesong = new CfgInfo<Dota2Item>(27044, "Eaglesong")
				.setPrice(3300).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Eaglesong").setAgility(25));
		public static CfgInfo<Dota2Item> mysticStaff = new CfgInfo<Dota2Item>(27045, "Mystic Staff")
				.setPrice(2700).setColumn(Column.SECRET_SHOP)
				.setWeaponDamage(2).setPassiveBuff(new Buff("Mystic Staff").setIntelligence(25));
		public static CfgInfo<Dota2Item> vitalityBooster = new CfgInfo<Dota2Item>(27046, "Vitality Booster")
				.setPrice(1100).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Vitality Booster").setHealth(250));
		public static CfgInfo<Dota2Item> energyBooster = new CfgInfo<Dota2Item>(27047, "Energy Booster")
				.setPrice(1000).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Energy Booster").setMana(250));
		public static CfgInfo<Dota2Item> pointBooster = new CfgInfo<Dota2Item>(27048, "Point Booster")
				.setPrice(1200).setColumn(Column.SECRET_SHOP)
				.setPassiveBuff(new Buff("Point Booster").setHealth(200).setMana(150));
		
		// Items column: Consumables ==================================================================
//		clarity
		public static CfgInfo<Tango> tango = new CfgInfo<Tango>(27002, "Tango")
				.setPrice(30).setColumn(Column.CONSUMABLES)
				.setDescription("Use: Eat Tree - Consume a tree to restore HP over time."
						+ "Comes with 3 charges.\n[Duration:] {16}\n[Health restored:] {115}");
//		healingSalve,
//		smokeOfDeceit,
//		townPortal,
//		dustOfAppearance,
//		animalCourier,
//		flyingCourier,
//		observerWard,
//		sentryWard,
//		bottle
		
		// Item column: Attributes ====================================================================
		public static CfgInfo<Dota2Item> ironBranch = new CfgInfo<Dota2Item>(27012, "Iron Branch")
				.setPrice(53).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Iron Branch").setStrength(1).setAgility(1).setIntelligence(1));
		public static CfgInfo<Dota2Item> gauntletsOfStrength = new CfgInfo<Dota2Item>(27013, "Gauntlets of Strength")
				.setPrice(150).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Gauntlets of Strength").setStrength(3));
		public static CfgInfo<Dota2Item> slippersOfAgility = new CfgInfo<Dota2Item>(27014, "Slippers of Agility")
				.setPrice(150).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Slippers of Agility").setAgility(3));
		public static CfgInfo<Dota2Item> mantleOfIntelligence =	new CfgInfo<Dota2Item>(27015, "Mantle of Intelligence")
				.setPrice(150).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Mantle of Intelligence").setIntelligence(3));
		public static CfgInfo<Dota2Item> circlet = new CfgInfo<Dota2Item>(27016, "Circlet")
				.setPrice(185).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Circlet").setStrength(2).setAgility(2).setIntelligence(2));
		public static CfgInfo<Dota2Item> beltOfStrength = new CfgInfo<Dota2Item>(27017, "Belt of Strength")
				.setPrice(450).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Belt of Strength").setStrength(6));
		public static CfgInfo<Dota2Item> bandOfElvenskin = new CfgInfo<Dota2Item>(27018, "Band of Elvenskin")
				.setPrice(450).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Band of Elvenskin").setAgility(6));
		public static CfgInfo<Dota2Item> robeOfTheMagi = new CfgInfo<Dota2Item>(27019, "Robe of the Magi")
				.setPrice(450).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Robe of the Magi").setIntelligence(6));
		public static CfgInfo<Dota2Item> ogreClub = new CfgInfo<Dota2Item>(27020, "Ogre Club")
				.setPrice(1000).setColumn(Column.ATTRIBUTES)
				.setWeaponDamage(7).setPassiveBuff(new Buff("Ogre Club").setStrength(10));
		public static CfgInfo<Dota2Item> bladeOfAlacrity = new CfgInfo<Dota2Item>(27021, "Blade of Alacrity")
				.setPrice(1000).setColumn(Column.ATTRIBUTES)
				.setWeaponDamage(7).setPassiveBuff(new Buff("Blade of Alacrity").setAgility(10));
		public static CfgInfo<Dota2Item> staffOfWizardry = new CfgInfo<Dota2Item>(27010, "Staff of Wizardry")
				.setPrice(1000).setWeaponDamage(2).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Staff of Wizardry").setIntelligence(10));
		public static CfgInfo<Dota2Item> ultimateOrb = new CfgInfo<Dota2Item>(27022, "Ultimate Orb")
				.setPrice(2100).setColumn(Column.ATTRIBUTES)
				.setPassiveBuff(new Buff("Ultimate Orb").setStrength(10).setAgility(10).setIntelligence(10));
		
		// Item column: Armaments =====================================================================
		public static CfgInfo<Dota2Item> ringOfProtection = new CfgInfo<Dota2Item>(27005, "Ring of Protection")
				.setPrice(175).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Ring of Protection").setArmor(2));
		public static CfgInfo<QuellingBlade> quellingBlade = new CfgInfo<QuellingBlade>(27003, "Quelling Blade")
				.setPrice(225).setWeaponDamage(6).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Quelling Blade").setDamagePercent(32, 16).setDoesNotStack())
				.setDescription("Active: Destroy Tree/Ward - Destroy a target tree, or deals 100 damage to a ward.\n" +
				"Passive: Quell - Gives bonus attack damage against non-hero units, depending on the type of hero you are.\n" +
				"[Melee bonus:] {32%}\n[Ranged bonus:] {12%}");
		public static CfgInfo<Dota2Item> stoutShield = new CfgInfo<Dota2Item>(27031, "Stout Shield")
				.setPrice(250).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Stout Shield").setDamageBlock(20, 10, 60))
				.setDescription("Passive: Damage Block - Gives a chance to block damage, depending on the type of hero you are.");
		public static CfgInfo<Dota2Item> bladesOfAttack = new CfgInfo<Dota2Item>(27023, "Blades of Attack")
				.setPrice(450).setWeaponDamage(5).setIsFull3D(false).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Blades of Attack").setDamage(9));
		public static CfgInfo<Dota2Item> chainmail = new CfgInfo<Dota2Item>(27024, "Chainmail")
				.setPrice(550).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Chainmail").setArmor(5));
		public static CfgInfo<Dota2Item> helmOfIronWill = new CfgInfo<Dota2Item>(27025, "Helm of Iron Will")
				.setPrice(950).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Helm of Iron Will").setArmor(5).setHealthRegen(3));
		public static CfgInfo<Dota2Item> broadsword = new CfgInfo<Dota2Item>(27026, "Broadsword")
				.setPrice(1200).setWeaponDamage(7).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Broadsword").setDamage(18));
		public static CfgInfo<Dota2Item> quarterstaff = new CfgInfo<Dota2Item>(27027, "Quarterstaff")
				.setPrice(900).setWeaponDamage(4).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Quarterstaff").setDamage(10).setAttackSpeed(10));
		public static CfgInfo<Dota2Item> claymore = new CfgInfo<Dota2Item>(27028, "Claymore")
				.setPrice(1400).setWeaponDamage(7).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Claymore").setDamage(21));
//		javelin
		public static CfgInfo<Dota2Item> platemail = new CfgInfo<Dota2Item>(27029, "Platemail")
				.setPrice(1400).setColumn(Column.ARMAMENTS)
				.setPassiveBuff(new Buff("Platemail").setArmor(10));
		public static CfgInfo<Dota2Item> mithrilHammer = new CfgInfo<Dota2Item>(27030, "Mithril Hammer")
				.setPrice(1600).setColumn(Column.ARMAMENTS)
				.setWeaponDamage(7).setPassiveBuff(new Buff("Mithril Hammer").setDamage(24));
		
		// Item column: Arcane ========================================================================
//		magicStick
		public static CfgInfo<Dota2Item> sagesMask = new CfgInfo<Dota2Item>(27009, "Sage's Mask")
				.setPrice(325).setColumn(Column.ARCANE)
				.setPassiveBuff(new Buff("Sage's Mask").setManaRegenPercent(50));
		public static CfgInfo<Dota2Item> ringOfRegen = new CfgInfo<Dota2Item>(27032, "Ring of Regen")
				.setPrice(350).setColumn(Column.ARCANE)
				.setPassiveBuff(new Buff("Ring of Regen").setHealthRegen(2));
		public static CfgInfo<Dota2Item> bootsOfSpeed = new CfgInfo<Dota2Item>(27006, "Boots of Speed")
				.setPrice(450).setColumn(Column.ARCANE)
				.setPassiveBuff(new Buff("Boots of Speed").setMovementSpeed(50));
		public static CfgInfo<Dota2Item> glovesOfHaste = new CfgInfo<Dota2Item>(27033, "Gloves of Haste")
				.setPrice(500).setColumn(Column.ARCANE)
				.setPassiveBuff(new Buff("Gloves of Haste").setAttackSpeed(15));
		public static CfgInfo<Dota2Item> cloak = new CfgInfo<Dota2Item>(27034, "Cloak")
			.setPrice(550).setColumn(Column.ARCANE)
			.setPassiveBuff(new Buff("Cloak").setSpellResistance(15))
			.setDescription("Multiple instances of spell resistance from items do not stack.");
//		gemOfTrueSight
//		morbidMask
//		ghostScepter
		public static CfgInfo<Dota2Item> talismanOfEvasion = new CfgInfo<Dota2Item>(27035, "Talisman of Evasion")
				.setPrice(1800).setColumn(Column.ARCANE)
				.setPassiveBuff(new Buff("Talisman of Evasion").setEvasionPercent(25));
		public static CfgInfo<BlinkDagger> blinkDagger = new CfgInfo<BlinkDagger>(27001, "Blink Dagger")
				.setPrice(2150).setWeaponDamage(4).setColumn(Column.ARCANE)
				.setDescription("Active: Blink - Teleport to a target point up to 1200 units away. " +
				"If damage is taken from an enemy hero, Blink Dagger cannot be used for 3 seconds.");
//		shadowAmulet
		
		// Item column: Common ========================================================================
		public static CfgInfo<Dota2Item> wraithBand = new CfgInfo<Dota2Item>(27036, "Wraith Band")
				.setPrice(150).setRecipe(slippersOfAgility, circlet).setColumn(Column.COMMON)
				.setPassiveBuff(new Buff("Wraith Band").setStrength(3).setAgility(6).setIntelligence(3).setDamage(3));
		public static CfgInfo<Dota2Item> nullTalisman = new CfgInfo<Dota2Item>(27037, "Null Talisman")
				.setPrice(135).setRecipe(mantleOfIntelligence, circlet).setColumn(Column.COMMON)
				.setPassiveBuff(new Buff("Null Talisman").setStrength(3).setAgility(3).setIntelligence(6).setDamage(3));
//		magicWand
		public static CfgInfo<Dota2Item> bracer = new CfgInfo<Dota2Item>(27038, "Bracer")
				.setPrice(190).setRecipe(gauntletsOfStrength, circlet).setColumn(Column.COMMON)
				.setPassiveBuff(new Buff("Bracer").setStrength(6).setAgility(3).setIntelligence(3).setDamage(3));
//		poorMansShield
//		soulRing
//		phaseBoots
//		powerTreads
		public static CfgInfo<Dota2Item> oblivionStaff = new CfgInfo<Dota2Item>(27051, "Oblivion Staff")
				.setWeaponDamage(2).setColumn(Column.COMMON)
				.setRecipe(quarterstaff, sagesMask, robeOfTheMagi)
				.setPassiveBuff(new Buff("Oblivion Staff").setIntelligence(6).setAttackSpeed(10).setDamage(15).setManaRegenPercent(75));
		public static CfgInfo<Dota2Item> perseverance = new CfgInfo<Dota2Item>(27050, "Perseverance")
				.setRecipe(ringOfHealth, voidStone).setColumn(Column.COMMON)
				.setPassiveBuff(new Buff("Perseverance").setHealthRegen(5).setManaRegenPercent(125).setDamage(10));
//		handOfMidas
//		bootsOfTravel
		
		// Item column: Support =======================================================================
//		ringOfBasilius
//		headdress
//		buckler
//		urnOfShadows
//		ringOfAquila
//		tranquilBoots
//		medallionOfCourage
//		arcaneBoots
//		drumOfEndurance
//		vladmirsOffering
//		mekansm
//		pipeOfInsight
		
		// Item column: Caster ========================================================================
//		forceStaff
//		necronomicon
		public static CfgInfo<EulsScepter> eulsScepter = new CfgInfo<EulsScepter>(27004, "Eul's Scepter of Divinity")
				.setPrice(600).setWeaponDamage(2).setColumn(Column.CASTER)
				.setPassiveBuff( new Buff("Eul's Scepter of Divinity").setMovementSpeed(30).setIntelligence(10).setManaRegenPercent(150) )
				.setRecipe(staffOfWizardry, sagesMask, voidStone)
				.setDescription("Active: Cyclone - Target unit is swept up in a cyclone for 2.5 seconds, " +
				"and is invulnerable.\nFlat movement speed bonuses from multiple Eul's Scepters do not stack.");
//		dagon
//		veilOfDiscord
//		rodOfAtos
//		AghanimsScepter
//		orchidMalevolence
//		refresherOrb
//		scytheOfVyse
		
		// Item column: Weapons
//		crystalys
//		armletOfMordiggian
//		skullBasher
//		shadowBlade
//		battleFury
//		etherealBlade
//		radiance
//		monkeyKingBar
//		daedalus
		public static CfgInfo<Dota2Item> butterfly = new CfgInfo<Dota2Item>(27053, "Butterfly")
				.setWeaponDamage(7).setColumn(Column.WEAPONS)
				.setRecipe(talismanOfEvasion, quarterstaff, eaglesong)
				.setPassiveBuff(new Buff("Butterfly").setAgility(30).setDamage(30).setEvasionPercent(35).setAttackSpeed(30));
		public static CfgInfo<Dota2Item> divineRapier = new CfgInfo<Dota2Item>(27054, "Divine Rapier")
				.setDropsOnDeath(true).setWeaponDamage(7).setColumn(Column.WEAPONS)
				.setRecipe(sacredRelic, demonEdge)
				.setPassiveBuff(new Buff("Divine Rapier").setDamage(300));
//		abyssalBlade
		
		// Item column: Armor
//		hoodOfDefiance
//		bladeMail
		public static CfgInfo<Dota2Item> vanguard = new CfgInfo<Dota2Item>(27052, "Vanguard")
				.setRecipe(ringOfHealth, vitalityBooster, stoutShield).setColumn(Column.ARMOR)
				.setPassiveBuff(new Buff("Vanguard").setHealth(250).setHealthRegen(6).setDamageBlock(40, 20, 70))
				.setDescription("Passive: Damage Block - Gives a chance to block damage, depending on the type of hero you are.");
		public static CfgInfo<Dota2Item> soulBooster = new CfgInfo<Dota2Item>(27049, "Soul Booster")
				.setRecipe(vitalityBooster, energyBooster, pointBooster).setColumn(Column.ARMOR)
				.setPassiveBuff(new Buff("Soul Booster").setHealth(450).setMana(400).setHealthRegen(4).setManaRegenPercent(100));
//		blackKingBar
//		shivasGuard
//		mantaStyle
//		bloodstone
//		linkensSphere
//		assaultCuirass
//		heartOfTarrasque
		
		// Item column: Artifacts
//		helmOfTheDominator
//		maskOfMadness
//		sange
//		yasha
//		maelstrom
//		diffusalBlade
//		desolator
//		heavensHalberd
//		sangeAndYasha
//		mjollnir
//		eyeOfSkadi
//		satanic
		
		// Blocks
		public static CfgInfo<BlockCycloneContainer> cycloneContainer = new CfgInfo<BlockCycloneContainer>(2700, "Cyclone Container");
}