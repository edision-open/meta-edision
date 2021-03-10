SUMMARY = "Qualcomm QCA6174 firmware"
HOMEPAGE = "https://www.qualcomm.com/"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "osmio4k|osmio4kplus"

PR = "r1"

SRC_URI = "git://github.com/edision-open/linux-firmware.git"

SRCREV = "5ad65c3de04150106e69b5d6517c838226618798"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 btfw32.tlv ${D}${nonarch_base_libdir}/firmware/btfw32.tlv
    install -m 0644 bdwlan30.bin ${D}${nonarch_base_libdir}/firmware/bdwlan30.bin
    install -m 0644 otp30.bin ${D}${nonarch_base_libdir}/firmware/otp30.bin
    install -m 0644 qwlan30.bin ${D}${nonarch_base_libdir}/firmware/qwlan30.bin
    install -m 0644 utf30.bin ${D}${nonarch_base_libdir}/firmware/utf30.bin
    install -d ${D}${nonarch_base_libdir}/firmware/wlan
    install -m 0644 wlan/cfg.dat ${D}${nonarch_base_libdir}/firmware/wlan/cfg.dat
    install -m 0644 wlan/qcom_cfg.ini ${D}${nonarch_base_libdir}/firmware/wlan/qcom_cfg.ini
}

FILES_${PN} += "${nonarch_base_libdir}/firmware"
