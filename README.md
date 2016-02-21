# boot-format-checker

A boot plugin to check indentation against cljfmt.

Heavily inspired by [lein-cljfmt](https://github.com/weavejester/cljfmt)
to the point where it requres both cljfmt *and* lein-cljfmt.

Provides:
- `check-formatting` task, which shows improperly formatted code

```clojure
[boot-format-checker "0.1.0"] ;; latest release
```

## Usage

```clojure
$ boot -d boot-format-checker check-formatting
Checking src/foo/bar.clj...
Checking src/foo/baz.clj...

$ boot -d boot-format-checker check-formatting --no-color --context 2
Checking src/foo/bar.clj...
Checking src/foo/baz.clj...
```

## Note
The `fix` task from lein-cljfmt seems to go against the boot philosophy.

## License

Copyright (C) 2016 Derek Passen.

Licensed under the [Eclipse Public License](https://www.eclipse.org/legal/epl-v10.html) (the same as Clojure).
