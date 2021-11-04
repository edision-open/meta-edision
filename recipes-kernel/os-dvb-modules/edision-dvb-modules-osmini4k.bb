KV = "5.15.0"
SRCDATE = "20211103"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "35207225373ea8ae105ba411aa17e8b5"
SRC_URI[sha256sum] = "3e71e7f3533e7cf936663b4ca55b0d10cc0f1025482660e27ffcc849384ea852"
