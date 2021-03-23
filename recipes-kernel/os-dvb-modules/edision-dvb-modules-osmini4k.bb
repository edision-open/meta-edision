KV = "5.9.0"
SRCDATE = "20210323"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "e993ef9aee789f4574b749688789b1f7"
SRC_URI[sha256sum] = "048dc5262fef25ae4d1bbd2ce5cf211d94212dcc055dbea5c745735b9a275679"
