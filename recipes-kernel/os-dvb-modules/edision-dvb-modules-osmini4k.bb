KV = "5.12.0"
SRCDATE = "20210428"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "54c5f9fb73ae13fc508f11c762b0f3f4"
SRC_URI[sha256sum] = "1b4f26604193f460e5159db676965597ae389b328a992922df91d03b7962d20e"
