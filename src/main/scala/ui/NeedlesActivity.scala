package cldellow.ballero.ui

import cldellow.ballero.R
import cldellow.ballero.service._
import cldellow.ballero.data._
import scala.xml.XML

import scala.collection.JavaConversions._
import android.app.Activity
import android.content._
import android.location._
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget._
import greendroid.app._
import greendroid.widget._
import greendroid.widget.item._

class NeedlesActivity extends GDListActivity with SmartActivity {
  val TAG = "NeedlesActivity"

  var adapter: ItemAdapter = null

  val progressItem = new ProgressItem("loading items")
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    adapter = new ItemAdapter(this)
    adapter.add(progressItem)
    setListAdapter(adapter)
    setTitle("your needles")
  }

  override def onResume {
    super.onResume
    Data.currentUser.get.needles.render(FetchIfNeeded, onNeedlesChanged)
  }

  private def onNeedlesChanged(needles: List[Needle], pending: Boolean) {
    adapter.remove(progressItem)
    needles.groupBy { _.kind }.foreach { case (kind, needles) =>
      adapter.add(new SeparatorItem("%s %s".format(needles.length, if(kind == "dp") "double-pointed" else kind)))
      needles.foreach { needle =>
        adapter.add(new TextItem("%s (%s)".format(needle.gaugeMetric, needle.comment)))
      }
    }

    if(needles.isEmpty)
      adapter.add(new TextItem("you have no needles!"))

    onContentChanged()
  }

  override def onListItemClick(l: ListView, v: View, position: Int, id: Long) {
  }

}