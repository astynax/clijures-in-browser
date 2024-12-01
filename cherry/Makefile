.PHONY: serve
serve: public/core.mjs
	npx http-server public/ --port 8000

public/core.mjs: core.cljs
	npx cherry compile core.cljs && cp core.mjs public/core.mjs
