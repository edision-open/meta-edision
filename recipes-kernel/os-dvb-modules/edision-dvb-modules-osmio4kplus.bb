KV = "5.9.0"
SRCDATE = "20210319"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4kplus"

SRC_URI[md5sum] = "45c902e27726c6378c2cb880be31dd60"
SRC_URI[sha256sum] = "5dbbdb37d59d1165bc851bfcea5193dd9b3b9c0eb039f2bc11711a1db97872b6"
