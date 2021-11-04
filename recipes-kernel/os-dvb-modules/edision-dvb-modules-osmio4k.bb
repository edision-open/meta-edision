KV = "5.15.0"
SRCDATE = "20211103"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[md5sum] = "29a6e6be629e9ba71ba4f924986073ab"
SRC_URI[sha256sum] = "569c828b37c952b1bca752a139d0073545335f73a00e4033433b33ca18b4fc71"

