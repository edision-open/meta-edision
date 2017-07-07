SUMMARY = "Firmware for rtl8723bs"
LICENSE = "CLOSED"

inherit allarch

PR = "r1"

SRC_URI = "\
    https://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git/plain/rtl_bt/rtl8723b_fw.bin;name=rtl8723b_fw.bin \
    https://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git/plain/rtlwifi/rtl8723bs_nic.bin;name=rtl8723bs_nic.bin \
    https://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git/plain/rtlwifi/rtl8723bs_wowlan.bin;name=rtl8723bs_wowlan.bin \
"
S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -d ${D}${base_libdir}/firmware/rtl_bt
	install -m 0644 rtl8723b_fw.bin ${D}${base_libdir}/firmware/rtl_bt
	install -d ${D}${base_libdir}/firmware/rtlwifi
	install -m 0644 rtl8723bs_nic.bin ${D}${base_libdir}/firmware/rtlwifi
	install -d ${D}${base_libdir}/firmware/rtlwifi
	install -m 0644 rtl8723bs_wowlan.bin ${D}${base_libdir}/firmware/rtlwifi
}

SRC_URI[rtl8723b_fw.bin.md5sum] = "b3363f17ba07a53bfd891fe1b4072e0b"
SRC_URI[rtl8723b_fw.bin.sha256sum] = "c9c8a9f6ebd90b7449a7e4d38ee39952dc7cc47d6c1d054e42cfbb5e4d818853"
SRC_URI[rtl8723bs_nic.bin.md5sum] = "67d4aad0db155a701610b156473a75fd"
SRC_URI[rtl8723bs_nic.bin.sha256sum] = "a52b5a7be4841b4b2839eddf5122b3300a3610866abe4bb3c3c9e444c8ab7969"
SRC_URI[rtl8723bs_wowlan.bin.md5sum] = "2bf10334c296ec239378933b4e6908b6"
SRC_URI[rtl8723bs_wowlan.bin.sha256sum] = "534f6c4ad8a8068f7888db7af83408f0d2ef04e5d4fc8514e07522a4b0bab3a7"
