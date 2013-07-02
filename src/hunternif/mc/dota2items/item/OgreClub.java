package hunternif.mc.dota2items.item;

import net.minecraft.entity.Entity;
import hunternif.mc.dota2items.core.buff.Buff;

public class OgreClub extends Dota2Item {

	public OgreClub(int id) {
		super(id);
		passiveBuff = new Buff(this).setStrength(10);
		setPrice(1000);
	}
	
	@Override
	public int getDamageVsEntity(Entity entity) {
		return 7;
	}

	@Override
	public boolean isFull3D() {
		return true;
	}
}