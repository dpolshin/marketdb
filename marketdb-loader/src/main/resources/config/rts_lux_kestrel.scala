import com.ergodicity.marketdb.loader.util.BatchSettings
import com.ergodicity.marketdb.loader.{KestrelLoaderConfig, KestrelSettings, RtsTradeLoader}
import java.io.File

new KestrelLoaderConfig(KestrelSettings("localhost", 22133, "trades", 10), BatchSettings(100, Some(300000))) {
  admin.httpPort = 10000

  val dir = new File("C:\\Dropbox\\Dropbox\\rts")
  if (!dir.isDirectory) {
    throw new IllegalStateException("Directory doesn't exists: " + dir.getAbsolutePath)
  }

  val url = "http://ftp.rts.ru/pub/info/stats/history"
  val pattern = "'/F/'YYYY'/FT'YYMMdd'.zip'"

  val loader = new RtsTradeLoader(dir, url, pattern)
}
