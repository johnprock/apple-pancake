(ns helloworld.views.posts)

(defrecord post [title content date tags])

(def p0 (post. "Hello" "<p>  My website is finally up and running in clojure. The posting system still needs some work.
	I've been having problems with Heroku and file IO. My post files aren't able to be slurped up on the Heroku servers. I'm
	probably going to upadate the writings section so that the main button leads to an index of all posts. E is working on a 
	web blog interface and I may do the same. The idea is to be able to post from a web facing interface withough touching the code. 
	Also check out <a href=\"http://iheanyi.com\">http://iheanyi.com</a></p>" "18/7/2013" "meta web first"))

(def p1 (post. "Group Sum" "<p>   I've been looking at <a href=\"http://codingbat.com\">coding bat</a> and was interested in what
	a Haskell solution would look like to some of the problems. The first question in the hard recursion section is interesting 
	and reminds me of an Nvidia interview question. Given a set of numbers and a target, is there a group of numbers that sum to 
	the target. Here's my Haskell solution:
	<pre class=\"brush: haskell\">groupSum :: Int -> [Int] -> Int -> Bool
    groupSum start nums target 
      | start >= length nums = if target == 0
	                           then True
	                           else False
	  | otherwise = add || notadd
	  where add =  groupSum (start+1) nums target
	  notadd = groupSum (start+1) nums (target - (nums !! start))</pre></p>" "18/7/2013" "haskell"))



(def posts [p0 p1])
