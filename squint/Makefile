.PHONY: serve
serve: public/main.js
	npx http-server public/ --port 8000

public/main.js: core.mjs
	npx esbuild --bundle core.mjs --minify --outfile=public/main.js

core.mjs: core.cljs
	npx squint compile core.cljs
