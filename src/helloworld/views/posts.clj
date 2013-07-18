(ns helloworld.views.posts)

(defrecord post [title content date tags])

(def p0 (post. "Hello" "<p>  My website is finally up and running in clojure. The posting system still needs some work.
	I've been having problems with Heroku and file IO. My post files aren't able to be slurped up on the Heroku servers. I'm
	probably going to upadate the writings section so that the main button leads to an index of all posts. Also check out http://iheanyi.com</p>" "18/7/2013" "meta web first") )

(def posts [p0])
