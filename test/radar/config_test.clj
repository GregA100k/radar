(ns radar.config-test
  (:require [clojure.test :refer :all]
            [radar.config :refer :all]))

(def sample-configuration
  [{"name" "Robots"
    "categories" ["Ar Drone"
                  "Phamtom X Hexapod"
                  "Myo Armband"
                  "Roomba"]
    }
   {"name" "Languages"
    "categories" ["Clojure"
                  "Idris"
                  "Pixie"
                  "JavaScript"]
    }
   {"name" "Cute Animals"
    "categories" ["Llamas"
                  "Alpagas"
                  "Wombats"
                  "Hedgehogs"]
    }
   {"name" "Tasty Food"
    "categories" ["Crumpets"
                  "Mint Tim Tams"
                  "Raclette"
                  "Egg Nog"]
    }])

(deftest test-read-configuration
  (let [expected sample-configuration]
    (is (= expected (read-configuration "sample.json")))))

(deftest test-categories
  (let [expected ["Robots" "Languages" "Cute Animals" "Tasty Food"]]
    (is (= expected (categories sample-configuration)))))

(deftest test-targets
  (let [expected [["Ar Drone"
                   "Phamtom X Hexapod"
                   "Myo Armband"
                   "Roomba"]
                  ["Clojure"
                   "Idris"
                   "Pixie"
                   "JavaScript"]
                  ["Llamas"
                   "Alpagas"
                   "Wombats"
                   "Hedgehogs"]
                  ["Crumpets"
                   "Mint Tim Tams"
                   "Raclette"
                   "Egg Nog"]]]
    (is (= expected (targets sample-configuration)))))