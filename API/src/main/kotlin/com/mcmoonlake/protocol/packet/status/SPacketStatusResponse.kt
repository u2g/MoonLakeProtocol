/*
 * Copyright (C) 2016-Present The MoonLake (mcmoonlake@hotmail.com)
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

package com.mcmoonlake.protocol.packet.status

import com.mcmoonlake.protocol.packet.PacketAbstract
import com.mcmoonlake.protocol.packet.PacketBuffer
import com.mcmoonlake.protocol.packet.PacketServer
import com.mcmoonlake.protocol.wrapper.ServerInfo

data class SPacketStatusResponse(
        var info: ServerInfo
) : PacketAbstract(),
        PacketServer {

    constructor() : this(ServerInfo.SAMPLE)

    override fun read(data: PacketBuffer) {
        info = ServerInfo.fromJson(data.readString())
    }

    override fun write(data: PacketBuffer) {
        data.writeString(info.toJson())
    }
}
