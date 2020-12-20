TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"

require conf/machine/include/tune-mips32.inc

BOX_BRAND = "edision"

MACHINE_FEATURES += "HDMI"

KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.bin"

STB_PLATFORM = "edisionmips"
