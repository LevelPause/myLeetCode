import java.nio.file.Files
import java.nio.file.Path

del()

fun del() {
    val root = System.getProperty("user.dir")
    println("source dir: $root")
    val workDir = Path.of(Path.of(root).parent.toString(), "md", "all")
    println("work dir: $workDir")
    when (Files.exists(workDir)) {
        true -> {
            val list = Files.list(workDir);
            list.forEach {
                delEmptyFile(it)
            }
            list.close()
        }
        else -> {
            println("$workDir is not exists")
        }
    }

}

fun delEmptyFile(path: Path) {
    val s = Files.readString(path)
    if (s.isNullOrBlank()) {
        Files.delete(path)
        println("delete empty md file $path")
    }
}
