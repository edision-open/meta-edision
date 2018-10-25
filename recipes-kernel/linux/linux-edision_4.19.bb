require linux-os.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/edision-open/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	"

COMPATIBLE_MACHINE = "osmio4k"

SRC_URI[kernel.md5sum] = "740a90cf810c2105df8ee12e5d0bb900"
SRC_URI[kernel.sha256sum] = "0c68f5655528aed4f99dae71a5b259edc93239fa899e2df79c055275c21749a1"
SRC_URI[kernelpatch.md5sum] = "a74b85b7094ef29827e31212765948b4"
SRC_URI[kernelpatch.sha256sum] = "3d1d8faf69ab029159419925c383d964a9d5b6fd438588dc323cbe6ec11792b9"
