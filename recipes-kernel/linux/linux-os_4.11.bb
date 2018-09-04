require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	"

COMPATIBLE_MACHINE = "osmega|osmini|osminiplus"

SRC_URI[kernel.md5sum] = "251a5deee0fa6daf3f356b1bbda9eab8"
SRC_URI[kernel.sha256sum] = "b67ecafd0a42b3383bf4d82f0850cbff92a7e72a215a6d02f42ddbafcf42a7d6"
SRC_URI[kernelpatch.md5sum] = "0c8fa6cf07394e6a8ac9e3495b2d43c5"
SRC_URI[kernelpatch.sha256sum] = "f3876390e9cb3b02a0f20a374a852c2dd0a018f71887969a0fd66439a526d8e8"
