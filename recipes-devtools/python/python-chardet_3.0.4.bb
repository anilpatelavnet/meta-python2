SUMMARY = "Universal encoding detector for Python 2 and 3"
DESCRIPTION = "Character encoding auto-detection in Python. As smart as your \
browser. Open source."
HOMEPAGE = "https://github.com/chardet/chardet"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "7dd1ba7f9c77e32351b0a0cfacf4055c"
SRC_URI[sha256sum] = "84ab92ed1c4d4f16916e05906b6b75a6c0fb5db821cc65e70cbd64a3e2a5eaae"

# setup.py of chardet needs this.
DEPENDS += "${PYTHON_PN}-pytest-runner-native"

PACKAGES =+ "${PN}-cli"

RDEPENDS_${PN}-cli = "${PN} "

FILES_${PN}-cli += " \
    ${PYTHON_SITEPACKAGES_DIR}/chardet/cli \
"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-logging \
"

inherit pypi setuptools

do_install_append() {
    mv ${D}${bindir}/chardetect ${D}${bindir}/chardetect-py2
}

RDEPENDS_${PN} += "${PYTHON_PN}-argparse"

BBCLASSEXTEND = "native nativesdk"
