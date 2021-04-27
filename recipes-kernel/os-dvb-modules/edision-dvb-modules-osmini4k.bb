KV = "5.12.0"
SRCDATE = "20210426"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "fce0c6f695567d4c635aef6afb80f87d"
SRC_URI[sha256sum] = "1de18804675a035cd014decf0279edfa52d7ce545a6f0e10645fc71ebb32bbf7"
