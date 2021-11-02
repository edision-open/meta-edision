KV = "5.14.0"
SRCDATE = "20211102"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[md5sum] = "8bff642020d4495a21b0505054152411"
SRC_URI[sha256sum] = "0761657fde15c28e38c79d68449d114ee1d0d01ba90bb28d10f7ab9c05327941"
