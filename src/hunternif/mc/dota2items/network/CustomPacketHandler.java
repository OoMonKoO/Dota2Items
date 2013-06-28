package hunternif.mc.dota2items.network;

import hunternif.mc.dota2items.Dota2Items;
import hunternif.mc.dota2items.network.CustomPacket.ProtocolException;

import java.util.logging.Level;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class CustomPacketHandler implements IPacketHandler {
	/*@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(Dota2Items.CHANNEL)) {
			
			if (OpenGuiPacket.parseAndApplyOpenGuiPacket(packet, (EntityPlayer) player)) {
				return;
			} else if (ShopFilterInputPacket.parseAndApply(packet, (EntityPlayer) player)) {
				return;
			} else if (ShopSellPacket.parseAndApply(packet, (EntityPlayer) player)) {
				return;
			} else if (ShopSetResultPacket.parseAndApply(packet, (EntityPlayer) player)) {
				return;
			}
			
		}
	}*/
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		try {
			EntityPlayer entityPlayer = (EntityPlayer)player;
			ByteArrayDataInput in = ByteStreams.newDataInput(packet.data);
			// Assuming your packetId is between 0 (inclusive) and 256 (exclusive).
			int packetId = in.readUnsignedByte();
			CustomPacket customPacket = CustomPacket.constructPacket(packetId);
			customPacket.read(in);
			customPacket.execute(entityPlayer, entityPlayer.worldObj.isRemote ? Side.CLIENT : Side.SERVER);
		} catch (ProtocolException e) {
			if (player instanceof EntityPlayerMP) {
				((EntityPlayerMP) player).playerNetServerHandler.kickPlayerFromServer("Protocol Exception!");
				FMLLog.log(Dota2Items.ID, Level.WARNING, e, "Player %s caused a Protocl Exception and was kicked.", ((EntityPlayer)player).username);
			}
		} catch (InstantiationException e) {
			throw new RuntimeException("Unexpected InstantiationException during Packet construction!", e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unexpected IllegalAccessException during Packet construction!", e);
		}
	}
}