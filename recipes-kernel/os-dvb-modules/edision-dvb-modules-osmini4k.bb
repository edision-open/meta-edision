KV = "5.12.0"
SRCDATE = "20210524"
MODNAMES = "brcmstb-${MACHINE} ci avl6261 avl6862 si2183"

RRECOMMENDS_${PN} += "linux-firmware-dvb-fe-avl62x1 linux-firmware-dvb-fe-avl68x2"

require os-dvb-modules.inc

COMPATIBLE_MACHINE = "osmini4k"

SRC_URI[md5sum] = "f81ae25fcb0f30dd347890608e156151"
SRC_URI[sha256sum] = "ee03f2ff199cec0712a149c487fe34c0f7eec228a098727cac63db537dc0b5ad"
