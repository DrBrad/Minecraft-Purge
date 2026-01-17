Purge
=====
Imagine the Purge in minecraft, this plugin does just that. Allow players to create groups,
claim land so that others cant touch it and disable PvP. However once the Purge happens all
protections are dropped for 24 hours. During the Purge players can modify claimed land, open
claimed land chests, and PvP other players.

Important Notes
-----------
Claims allow players to take chunks IE 16x16 blocks, which can be seen using the `/g map` command.
If a chunk is claimed by a group no other group or player can modify that chunk in any way, unless
of course it's the purge. Each group is given a default of `20 power` on group creation. For each
player that joins a group the group is given another `20 power` IE if there are 2 players in a group
the group has a total of `40 power`. When you claim a chunk you spend `1 power` to claim that chunk
and you can re-obtain that power by unclaiming that chunk. For x time the player plays the server the
group will gain an extra `x power`.

Ranks allow groups to have a trust system for players which allow certain players in the group to
modify chunks, claim land, set group homes, etc...

Group Commands
-----------
| Command                 | Description                                           |
|-------------------------|-------------------------------------------------------|
| /g help                 | List of all commands                                  |
| /g ?                    | List of all commands                                  |
| /g create               | Create a group                                        |
| /g invite               | Invite player to group                                |
| /g join                 | Join an existing group                                |
| /g leave                | Leave your current group                              |
| /g remove               | Remove a player from group                            |
| /g promote              | Promote player in group                               |
| /g demote               | Demote player in group                                |
| /g disband              | Delete group                                          |
| /g claim                | Claim land for group                                  |
| /g unclaim              | Unclaim land for group                                |
| /g autoclaim            | Automatically claim land for group                    |
| /g autounclaim          | Automatically unclaim land for group                  |
| /g home                 | Go to group home                                      |
| /g sethome              | Set group home                                        |
| /g warp                 | Warp to group warp                                    |
| /g warps                | List of groups warps                                  |
| /g setwarp              | Set group warp                                        |
| /g delwarp              | Remove group warp                                     |
| /g power                | Get groups power                                      |
| /g list                 | List of all groups                                    |
| /g rename               | Rename your group                                     |
| /g chat                 | Chat with all users in group                          |
| /g map                  | Shows visual representation of chunks owned by groups |
| /g claim safezone       | Claim land for safe zone                              |
| /g unclaim safezone     | Unclaim land for safe zone                            |
| /g claim pvpzone        | Claim land for pvp zone                               |
| /g unclaim pvpzone      | Unclaim land for pvp zone                             |
| /g autoclaim safezone   | Automatically claim land for safe zone                |
| /g autounclaim safezone | Automatically unclaim land for safe zone              |
| /g autoclaim pvpzone    | Automatically claim land for pvp zone                 |
| /g autounclaim pvpzone  | Automatically unclaim land for pvp zone               |
| /g chown                | Change group ownership                                |
| /g setpower             | Set group power                                       |
| /g rank                 | Get your rank in group                                |
| /g setdesc              | Set groups description                                |
| /g setcolor             | Set groups color                                      |
| /g version              | Version of Purge                                      |

Extra Commands
-----------
| Command   | Description                                               |
|-----------|-----------------------------------------------------------|
| /warp     | Warp to a location                                        |
| /warps    | List of warps                                             |
| /setwarp  | Set warp for server                                       |
| /delwarp  | Remove warp for server                                    |
| /home     | Teleport to players home                                  |
| /sethome  | Set players home                                          |
| /spawn    | Teleport to spawn                                         |
| /setspawn | Set server spawn                                          |
| /tpa      | Teleport request to player                                |
| /tpaa     | Teleport accept player                                    |
| /tpad     | Deny teleport for player                                  |
| /wild     | Teleport to a random location that isn't owned by a group |
| /msg      | Message a player privatly                                 |
| /wild     | Teleport randomly in the wild to land unclaimed.          |
| /gamemode | Better gamemode changing                                  |
| /back     | Go back to last location teleported                       |
