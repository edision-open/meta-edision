KV = "4.8.17"
SRCDATE = "20171019"
MODNAMES = "linuxdvb"

require os-dvb-modules.inc
SRC_URI = "http://source.mynonpublic.com/edision/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

COMPATIBLE_MACHINE = "osnino"

SRC_URI[md5sum] = "ccc102a2c69d6f08e7d0d59035104266"
SRC_URI[sha256sum] = "edf420c2aa54a30bc32481259f815acb94e447042c98765c7ec40cef19d56735"
