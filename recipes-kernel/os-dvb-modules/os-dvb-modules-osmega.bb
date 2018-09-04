KV = "4.11.0"
SRCDATE = "20171106"
MODNAMES = "brcmstb-${MACHINE} ci ftm4862 fts260 sp988x"

RDEPENDS_${PN} += "firmware-mn8847x"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmega"

SRC_URI[md5sum] = "83845498d61d5a92125550cc7d54df18"
SRC_URI[sha256sum] = "aa3fc1f0d3486ba2c4a8f7beeb13d6f2071d036988fc055f9d5ad899d8eea308"
