import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def DEFAULT_ENCODING = "UTF-8"
def DEFAULT_PERIOD = 1000
def DEFAULT_LINES_LIMIT = 1000

def cli = new CliBuilder()

cli.i(args:1, required: true, longOpt: 'input', 'input file')
cli.o(args:1, required: true, longOpt: 'output', 'output directory')
cli.p(args:1, longOpt: 'period', 'delay after each line written')
cli.e(args:1, longOpt: 'encoding', 'file encoding')
cli.l(args:1, longOpt: 'linesLimit', 'number of lines per single output file')

options = cli.parse(args)
options || System.exit(1)

def source = new File(options.i)
def dest = getLogFile()
def encoding = options.e ?: DEFAULT_ENCODING
def period = options.p != null ? Integer.valueOf(options.p) : DEFAULT_PERIOD
def linesLimit = options.l != null ? Integer.valueOf(options.l) : DEFAULT_LINES_LIMIT

def counter = 0;

source.eachLine(encoding, {
    dest.append(it + System.lineSeparator())
    counter++;

    if (counter % linesLimit == 0) {
        println "Wrote ${linesLimit} lines to ${dest.canonicalPath}"
        dest = getLogFile()
    }

    sleep(period)
})


File getLogFile() {
    def logFile = new File(options.o + '\\traxis-' + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM_HH-mm-ss")) + ".log")
    if (!logFile.exists()) {
        logFile.createNewFile()
    }
    return logFile
}
