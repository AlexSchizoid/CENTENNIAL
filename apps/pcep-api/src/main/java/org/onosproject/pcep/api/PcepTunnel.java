/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.pcep.api;

import java.util.List;

/**
 * Abstraction of a generalized  PCEP Tunnel entity (bandwidth pipe) for
 * L2 networks or L1/L0 networks, representation of e.g., VLAN, L1 ODUk
 * connection, WDM OCH, etc..
 */
public interface PcepTunnel extends PcepOperator {

    /**
     * Describe the type of a tunnel.
     */
    public static enum Type {

        /**
         * Signifies that this is a L0 OCH tunnel.
         */
        OCH,

        /**
         * Signifies that this is a L1 OTN tunnel.
         */
        OTN,

        /**
         * Signifies that this is a L2 tunnel.
         */
        UNI,
    }

    /**
     * The ability of a tunnel.
     */
    public static enum Ability {
        /**
         * no protected tunnel,if the tunnel is broken ,then the user is out of
         * service.
         */
        NOPROTECTED,

        /**
         * tunnel with rerouter ability.if a tunnel is broken, the tunnel will
         * try to find another path to provider service.
         */
        SILVER,

        /**
         * tunnel with 1 + 1 rerouter ability.if a tunnel is broken, there'll be
         * another tunnel providing service at once.
         */
        DIAMOND
    }

    public static enum PATHTYPE {

        /**
         * the preferred path.
         */
        FIRST,

        /**
         * the alternate path.
         */
        SECOND
    }

    /**
     * Get the type of a tunnel.
     *
     * @return tunnel type
     */
    public Type type();

    /**
     * Get the name of a tunnel.
     *
     * @return tunnel name
     */
    public String name();

    /**
     * Get the device id of destination endpoint of a tunnel.
     *
     * @return device id
     */
    public PcepDpid srcDeviceID();

    /**
     * Get the device id of source endpoint of a tunnel.
     *
     * @return device id
     */
    public PcepDpid dstDeviceId();

    /**
     * Get source port of a tunnel.
     *
     * @return port number
     */
    public long srcPort();

    /**
     * Get destination port of a tunnel.
     *
     * @return port number
     */
    public long dstPort();

    /**
     * Get the bandwidth of a tunnel.
     *
     * @return bandwidth
     */
    public long bandWidth();

    /**
     * Get the tunnel id.
     *
     * @return id of the PCEP tunnel
     */
    public long id();

    /**
     * Get the detail hop list of a tunnel.
     *
     * @return hop list
     */
    public List<PcepHopNodeDescription> getHopList();

    /**
     * Get the instance of a pcep tunnel,a instance is used to mark the times of a tunnel created.
     * instance and id identify a tunnel together.
     *
     * @return the instance of a tunnel.
     */
    public int getInstance();

    /**
     * Get the ability of a tunnel.NOPROTECTED,SILVER,or DIAMOND.
     *
     * @return ability of the tunenl
     */
    public Ability getSla();

    /**
     * Get the path type of a path if the tunnel's ability is diamond .
     *
     * @return the type of a path, the preferred or alternate.
     */
    public PATHTYPE getPathType();

    /**
     * Get the under lay tunnel id of VLAN tunnel.
     *
     * @return the tunnel id of a OCH tunnel under lay of a VLAN tunnel.
     */
    public long underLayTunnelId();

}