(ns {{ns}}.web.signup
  (:require [clojure.test :refer :all]
            [clj-webdriver.taxi :refer :all]
            [{{ns}}.web.setup :as s]))


(defn server-setup [f]
  (s/start-server)
  (f)
  (s/stop-server))

(defn browser-setup [f]
  (s/start-browser :htmlunit)
  (f)
  (s/stop-browser))

(use-fixtures :each browser-setup)
(use-fixtures :once server-setup)

(deftest ^:integration homepage-greeting
  (to s/test-base-url)
  (is (.contains (text "body") "Foo!")))