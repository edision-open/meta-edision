KV = "5.12.0"
SRCDATE = "20210426"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4kplus"

SRC_URI[md5sum] = "4dd16956d84255393d9b6b1f48a0637f"
SRC_URI[sha256sum] = "6469edd592cdbe1a1e941bc1502e65db6e148382bd36d96a25fccaea21fc214a"
