/*
 * Copyright (C) 2014-2022 Daniel Saukel
 *
 * This library is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNULesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.erethon.dungeonsxl.api.event.world;

import de.erethon.dungeonsxl.api.world.ResourceWorld;
import org.bukkit.event.HandlerList;

/**
 * Fired after an instance world is unloaded.
 *
 * @author Daniel Saukel
 */
public class InstanceWorldPostUnloadEvent extends ResourceWorldEvent {

    private static final HandlerList handlers = new HandlerList();
    private String instanceWorldName;

    public InstanceWorldPostUnloadEvent(ResourceWorld resource, String instanceWorldName) {
        super(resource);
        this.instanceWorldName = instanceWorldName;
    }

    /**
     * Returns the name the instance world had.
     *
     * @return the name the instance world had
     */
    public String getInstanceWorldName() {
        return instanceWorldName;
    }

    /**
     * Returns if the unloaded instance was an edit world.
     *
     * @return if the unloaded instance was an edit world
     */
    public boolean wasEditInstance() {
        return instanceWorldName.startsWith("DXL_Edit_");
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{resource=" + resource + "; instanceWorldName=" + instanceWorldName + "}";
    }

}
