KV = "5.5.16"
SRCDATE = "20200802"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "e80c151db90ed5ee9cb9fea0d7c429f0"
SRC_URI[sha256sum] = "512672e8e8d6fdb8871a04ea12760c6eaa66bb416554c30f1ffe2b4a91e24709"
SRC_URI[arm64.md5sum] = "b3ff5f9f2245892fd51deadc075a9267"
SRC_URI[arm64.sha256sum] = "03fc493ed1cac7976a08ada22882b96f1ef2f5b069e091275da1d3429da4bc64"
