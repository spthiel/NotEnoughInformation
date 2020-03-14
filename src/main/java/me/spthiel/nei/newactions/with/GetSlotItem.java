package me.spthiel.nei.newactions.with;

import net.eq2online.macros.scripting.actions.game.ScriptActionGetSlotItem;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;
import net.eq2online.macros.scripting.parser.ScriptCore;
import net.eq2online.util.Game;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;

import me.spthiel.nei.actions.BaseScriptAction;
import me.spthiel.nei.actions.IDocumentable;
import me.spthiel.nei.utils.Utils;

public class GetSlotItem extends BaseScriptAction {

	public GetSlotItem() {
		super("getslotitem");
	}

	public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
		ItemStack slotStack = null;
		if (params.length > 0) {
			int slotId = Math.max(0, ScriptCore.tryParseInt(provider.expand(macro, params[0], false), 0));
			slotStack = this.slotHelper.getSlotStack(slotId);
			
		}

		return Utils.getItemReturnValue(provider, macro, params, slotStack);
	}

	public boolean isPermissable() {
		return true;
	}

	public String getPermissionGroup() {
		return "inventory";
	}
	
	@Nonnull
	@Override
	public String getUsage() {
		
		return "getslot(<slotid>,<&idvar>,[#stacksizevar],[#datavar],[&nbt])";
	}
	
	@Nonnull
	@Override
	public String getDescription() {
		
		return "Gets information about the item in the specified slot";
	}
	
	@Nonnull
	@Override
	public String getReturnType() {
		
		return "Item ID of the item in the slot";
	}
}
