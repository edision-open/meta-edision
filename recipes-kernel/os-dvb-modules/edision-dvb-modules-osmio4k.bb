KV = "5.9.0"
SRCDATE = "20210323"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[md5sum] = "582a303938ea982929f36c873b7b030f"
SRC_URI[sha256sum] = "8c43852d6b0d411b987205ef6e137f7fca64e48cf738c4b5a20e8784c6cd2361"
