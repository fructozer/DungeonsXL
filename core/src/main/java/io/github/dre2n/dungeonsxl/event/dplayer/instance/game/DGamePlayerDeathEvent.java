/*
 * Copyright (C) 2012-2016 Frank Baumann
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.dre2n.dungeonsxl.event.dplayer.instance.game;

import io.github.dre2n.dungeonsxl.player.DGamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author Daniel Saukel
 */
public class DGamePlayerDeathEvent extends DGamePlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    private PlayerDeathEvent bukkitEvent;
    private int lostLives;

    public DGamePlayerDeathEvent(DGamePlayer dPlayer, PlayerDeathEvent bukkitEvent, int lostLives) {
        super(dPlayer);
        this.bukkitEvent = bukkitEvent;
        this.lostLives = lostLives;
    }

    /**
     * @return the bukkitEvent
     */
    public PlayerDeathEvent getBukkitEvent() {
        return bukkitEvent;
    }

    /**
     * @param bukkitEvent
     * the bukkitEvent to set
     */
    public void setBukkitEvent(PlayerDeathEvent bukkitEvent) {
        this.bukkitEvent = bukkitEvent;
    }

    /**
     * @return the lostLives
     */
    public int getLostLives() {
        return lostLives;
    }

    /**
     * @param lostLives
     * the lostLives to set
     */
    public void setLostLives(int lostLives) {
        this.lostLives = lostLives;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
