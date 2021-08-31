KV = "5.14.0"
SRCDATE = "20210831"
MODNAMES = "brcmstb-${MACHINE} brcmstb-decoder ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[md5sum] = "6812cdd8c078a5de9773e443592a98af"
SRC_URI[sha256sum] = "7302e9434b0d6c7e39f50c7ea118ade315ceff1837872b334fdd823dc1809a3f"
