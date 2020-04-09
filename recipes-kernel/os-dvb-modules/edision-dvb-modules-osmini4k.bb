KV = "5.5.16"
SRCDATE = "20200409"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "0a8f7e8f5f99c1f96263b9063cfd8d9f"
SRC_URI[sha256sum] = "eb01a237aaea197bdbe8d8aaa9c65231f3b07cd80e142957501ad55fb89434ff"
SRC_URI[arm64.md5sum] = "b3ff5f9f2245892fd51deadc075a9267"
SRC_URI[arm64.sha256sum] = "03fc493ed1cac7976a08ada22882b96f1ef2f5b069e091275da1d3429da4bc64"
