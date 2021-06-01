KV = "5.12.0"
SRCDATE = "20210601"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "a1575d1eb7c145ccf73ffa382b6efe99"
SRC_URI[sha256sum] = "a157e88b0074ded60101a2781ac845e178e0aa07019d60165a1b878fbfb06d87"
