package br.unisantos.cordenadas.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisantos.cordenadas.model.MyPoint;

@RestController
@RequestMapping("/mypoint")
public class MyPointResource {
	public static MyPoint point;

	@PostMapping("/create")
	public ResponseEntity<MyPoint> post() {
		point = new MyPoint();
		return ResponseEntity.ok(point);
	}

	@PostMapping("/create/{x}/{y}")
	public ResponseEntity<MyPoint> post(@PathVariable("x") int x, @PathVariable("y") int y) {
		point = new MyPoint(x, y);
		return ResponseEntity.ok(point);
	}

	@GetMapping
	public ResponseEntity<MyPoint> get() {
		return ResponseEntity.ok(point);
	}
	@GetMapping("/get_x")
	public ResponseEntity<Integer> getX() {
		return ResponseEntity.ok(point.getX());
	}
	@GetMapping("/get_y")
	public ResponseEntity<Integer> getY() {
		return ResponseEntity.ok(point.getY());
	}
	@GetMapping("/distance/{x}/{y}")
	public ResponseEntity<Double> distance(@PathVariable("x") int x, @PathVariable("y") int y){
		return ResponseEntity.ok(point.distance(x, y));
	}
	@GetMapping("/distance")
	public ResponseEntity<Double> distance(@RequestBody MyPoint another){
		return ResponseEntity.ok(point.distance(another));

	}
	@PutMapping("/set_x/{x}")
	public ResponseEntity<MyPoint> setX(@PathVariable("x") int x){
		point.setX(x);
		return ResponseEntity.ok(point);
	}
	@PutMapping("/set_y/{y}")
	public ResponseEntity<MyPoint> setY(@PathVariable("y") int y){
		point.setY(y);
		return ResponseEntity.ok(point);
	}
}