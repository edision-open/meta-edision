KV = "5.12.0"
SRCDATE = "20210511"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "900d659252e9fd6ed295050e0d71cb37"
SRC_URI[sha256sum] = "6418a213014b4ff2d8203608f626a0465dcaa3a5fbd9cf88e1ac3708b2d7b66b"
