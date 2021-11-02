KV = "5.14.0"
SRCDATE = "20211102"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4kplus"

SRC_URI[md5sum] = "9e86e479e491b72df4bbb2772da45744"
SRC_URI[sha256sum] = "97e8fd75bd85fb04d3407a6c40eea677a641a5f91b5149d6d21b1b0f361aa6c1"
