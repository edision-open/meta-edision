KV = "4.11.0"
SRCDATE = "20171106"
MODNAMES = "brcmstb-${MACHINE} ci ftm4862 fts260 sp988x"

RDEPENDS_${PN} += "firmware-mn8847x"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini"

SRC_URI[md5sum] = "f0874d73db686ce088c379af17202315"
SRC_URI[sha256sum] = "ca3d85ca3ce802e3084475505f353a5a5f3cd838018b8ee628c5c64e682b83df"
