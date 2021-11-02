KV = "5.14.0"
SRCDATE = "20211102"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "410c3959447f7ff5beb50b84b7ea5ea0"
SRC_URI[sha256sum] = "95f6294638a2266ee46e62e620a755a56f7f10555dd589f1a99314ef1f2b9f4a"
