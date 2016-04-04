DESCRIPTION = "USB DVB Driver for OPTI-Combo Tuner"

require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = " \
	kernel-module-dvb-usb-dvbsky \
	kernel-module-dvb-usb-v2 \
	kernel-module-m88ds3103 \
	kernel-module-si2168 \
	kernel-module-si2157 \
	firmware-dvb-fe-si2168 \
	"

PV = "2.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"
