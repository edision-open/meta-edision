SUMMARY = "OPTI-Combo DVB-T2/C USB Stick"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

DVBPROVIDER ?= "kernel"

RRECOMMENDS_${PN} = " \
	${DVBPROVIDER}-module-dvb-usb-dvbsky \
	${DVBPROVIDER}-module-dvb-usb-v2 \
	${DVBPROVIDER}-module-m88ds3103 \
	${DVBPROVIDER}-module-si2168 \
	${DVBPROVIDER}-module-si2157 \
	firmware-dvb-fe-si2168 \
	"

PV = "2.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"

