package org.golde.discordbot.shared.command.support;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.golde.discordbot.shared.ESSBot;
import org.golde.discordbot.shared.command.BaseCommand;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public abstract class SupportCommand extends BaseCommand {

	private static final Category CATEGORY_TICKET_SUPPORT = new Category("\ud83c\udfab Ticket Support Team");
	
	public SupportCommand(@Nonnull ESSBot bot, @Nonnull String nameIn, @Nullable String argsIn, @Nullable String helpIn, @Nullable String... aliasesIn) {
		super(bot, nameIn, argsIn, helpIn, aliasesIn);
		this.category = CATEGORY_TICKET_SUPPORT;
		this.requiredRole = CATEGORY_TICKET_SUPPORT.getName();
	}
	
	public final static boolean isSUpport(Member person) {
		for(Role r : person.getRoles()) {
			if(r.getName().equals(CATEGORY_TICKET_SUPPORT.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
}