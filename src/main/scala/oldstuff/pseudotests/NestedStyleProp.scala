package oldstuff.pseudotests

import com.raquo.laminar.api.L._
import oldstuff.components.Toggle2

object NestedStyleProp {

  def render($color: EventStream[String]): Div = {
    div(
      color <-- $color,
      span("HELLO"),
      child <-- $color.map(color => span(color))
    )
  }

  def apply(): Div = {

    val toggle = Toggle2("Big")
    val toggle2 = Toggle2("Red")

    val $fontSize = toggle
      .$checkedInput
//      .startWith(true)
      .map(checked => if (checked) "45px" else "30px")
    val $fontColor = toggle2
      .$checkedInput
//      .startWith(true)
      .map(checked => if (checked) "red" else "lime")

    div(
      className := "yolo",
      h1("MultiStyleProp"),
//      toggle.vnode,
      toggle2.node,
      div(
//        color <-- $fontColor,
//        fontSize <-- $fontSize,
        render($fontColor)
      )
    )
  }
}
