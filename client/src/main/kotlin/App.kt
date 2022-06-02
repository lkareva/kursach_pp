import component.*
import kotlinx.browser.document
import kotlinx.css.WhiteSpace
import kotlinx.css.margin
import kotlinx.css.px
import kotlinx.css.whiteSpace
import react.createElement
import react.dom.render
import react.query.QueryClient
import react.query.QueryClientProvider
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import react.router.dom.HashRouter
import react.router.dom.Link
import styled.css
import styled.styledSpan
import wrappers.cReactQueryDevtools

val queryClient = QueryClient()

fun main() {
    render(document.getElementById("root")!!) {
        BrowserRouter {
            QueryClientProvider {
                attrs.client = queryClient
                styledSpan {
                    css {
                        whiteSpace = WhiteSpace.preWrap
                        margin(top = 10.px, bottom = 10.px)
                    }
                    Link {
                        attrs.to = "/"
                        +"Расписание"
                    }
                    +" "
                    Link {
                        attrs.to = "/teachers"
                        +"Преподаватели"
                    }
                }
                Routes {
                    Route {
                        attrs.index = true
                        attrs.element =
                            createElement(fcContainerSchedule()) }
                    Route {
                        attrs.path = "/teachers"
                        attrs.element =
                            createElement(fcContainerTeachersList())
                    }
                    Route {
                        attrs.path = "/teachers/:surname"
                        attrs.element =
                            createElement(fcContainerTeacher())
                    }
                }
                child(cReactQueryDevtools()) {}
            }
        }
    }
}

