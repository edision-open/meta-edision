require linux-os.inc

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
	https://github.com/open-edision/edision-kernel/releases/download/v${PV}/edision-kernel-${PV}.patch.xz;apply=yes;name=kernelpatch \
	file://defconfig \
	"

COMPATIBLE_MACHINE = "osmega|osmini|osminiplus"

SRC_URI[kernel.md5sum] = "fc454157e2d024d401a60905d6481c6b"
SRC_URI[kernel.sha256sum] = "a45c3becd4d08ce411c14628a949d08e2433d8cdeca92036c7013980e93858ab"
SRC_URI[kernelpatch.md5sum] = "cc997a807a1cdfd5c0c69ad1076431da"
SRC_URI[kernelpatch.sha256sum] = "8fb684c5bc6f19c9ddd932cb1211f4a25b5eae7080dbe425a2c32fe1da2f1c8b"
